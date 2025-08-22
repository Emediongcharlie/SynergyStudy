import CourseCurriculum from "@/components/admin-view/courses/create-new-course/CourseCurriculum";
import CourseLanding from "@/components/admin-view/courses/create-new-course/CourseLanding";
import CourseSettings from "@/components/admin-view/courses/create-new-course/CourseSettings";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import {
  courseCurriculumInitialFormData,
  courseLandingInitialFormData,
} from "@/config";
import { AdminContext } from "@/context/admin-context";
import { AuthContext } from "@/context/authContext";
import {
  addNewCourseService,
  fetchAdminCourseDetailsService,
  updateCourseByIdService,
} from "@/services";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@radix-ui/react-tabs";
import React, { useContext, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

export default function CreateCourse() {
  const {
    courseLandingFormData,
    courseCurriculumFormData,
    setCourseLandingFormData,
    setCourseCurriculumFormData,
    currentEditedCourseId,
    setCurrentEditedCourseId,
  } = useContext(AdminContext);

  const { auth } = useContext(AuthContext);

  const navigate = useNavigate();

  const params = useParams();
  console.log(params);

  function isEmpty(value) {
    if (Array.isArray(value)) {
      return value.length === 0;
    }

    return value === "" || value === null || value === undefined;
  }

  function validateFormData() {
    for (const key in courseLandingFormData) {
      if (isEmpty(courseLandingFormData[key])) {
        return false;
      }
    }
    let hasFreePreview = false;

    for (const item of courseCurriculumFormData) {
      if (
        isEmpty(item.title) ||
        isEmpty(item.videoUrl) ||
        isEmpty(item.public_id)
      ) {
        return false;
      }

      if (item.freePreview) {
        hasFreePreview = true; //has at least one free preview
      }
    }
    return hasFreePreview;
  }

  async function handleCreateCourse() {
    const courseFinalFormData = {
      //these details in this form data depends if the backend is receiving all of them or not
      adminId: auth?.user?.id, //these depends on how it is sent from the backend
      adminName: auth?.user?.name,
      date: new Date(),
      ...courseLandingFormData,
      objectives: String,
      students: [],
      curriculum: courseCurriculumFormData,
      isPublished: true,
    };

    const response =
      currentEditedCourseId !== null
        ? await updateCourseByIdService(
            currentEditedCourseId,
            courseFinalFormData
          )
        : await addNewCourseService(courseFinalFormData);

    if (response?.success) {
      setCourseLandingFormData(courseLandingInitialFormData);
      setCourseCurriculumFormData(courseCurriculumInitialFormData);
      navigate(-1);
      setCurrentEditedCourseId(null);
    }

    console.log(courseFinalFormData, "courseFinalFormData");
  }

  async function fetchCurrentCourseDetails() {
    const response = await fetchAdminCourseDetailsService(
      currentEditedCourseId
    );
    console.log(response, "response"); //to check how the data is arranged

    if (response?.success) {
      const setCourseFormData = Object.keys(
        courseLandingInitialFormData
      ).reduce((acc, key) => {
        acc[key] = response?.data[key] || courseLandingInitialFormData[key];
        return acc;
      }, {});
      console.log(setCourseFormData, response?.data, "setCourseFormData");
      setCourseLandingFormData(setCourseFormData);
      setCourseCurriculumFormData(response?.data?.curriculum); // .data.curriculum depends on the data in the response from the backend
    }
  }

  useEffect(() => {
    if (currentEditedCourseId !== null) fetchCurrentCourseDetails();
  }, [currentEditedCourseId]);

  useEffect(() => {
    if (params?.courseId) setCurrentEditedCourseId(params?.courseId);
  }, [params?.courseId]);

  return (
    <div className="container mx-auto p-6 space-y-6">
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-semibold tracking-tight">
          Create a New Course
        </h1>
        <Button
          disabled={!validateFormData()}
          className="text-sm tracking-wide font-semibold px-6 py-2"
          onClick={handleCreateCourse}
        >
          Submit
        </Button>
      </div>

      <Card className="rounded-2xl shadow-md border border-gray-200">
        <CardContent className="p-6">
          <Tabs defaultValue="curriculum" className="w-full">
            <TabsList className="grid grid-cols-3 w-full border rounded-lg overflow-hidden bg-muted">
              <TabsTrigger
                value="curriculum"
                className="data-[state=active]:bg-white data-[state=active]:text-primary hover:bg-white/70 py-2 text-sm font-medium transition"
              >
                Curriculum
              </TabsTrigger>
              <TabsTrigger
                value="course-landing-page"
                className="data-[state=active]:bg-white data-[state=active]:text-primary hover:bg-white/70 py-2 text-sm font-medium transition"
              >
                Course Landing Page
              </TabsTrigger>
              <TabsTrigger
                value="settings"
                className="data-[state=active]:bg-white data-[state=active]:text-primary hover:bg-white/70 py-2 text-sm font-medium transition"
              >
                Thumbnail
              </TabsTrigger>
            </TabsList>

            <TabsContent value="curriculum" className="mt-4">
              <CourseCurriculum />
            </TabsContent>
            <TabsContent value="course-landing-page" className="mt-4">
              <CourseLanding />
            </TabsContent>
            <TabsContent value="settings" className="mt-4">
              <CourseSettings />
            </TabsContent>
          </Tabs>
        </CardContent>
      </Card>
    </div>
  );
}
