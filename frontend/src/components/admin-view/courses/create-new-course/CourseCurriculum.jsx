import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Switch } from "@/components/ui/switch";
import { courseCurriculumInitialFormData } from "@/config";
import { AdminContext } from "@/context/admin-context";
import { mediaUploadService } from "@/services";
import React, { useContext } from "react";

export default function CourseCurriculum() {
  const {
    courseCurriculumFormData,
    setCourseCurriculumFormData,
    mediaUploadProgress,
    setMediaUploadProgress,
  } = useContext(AdminContext);

  function handleNewLecture() {
    setCourseCurriculumFormData([
      ...courseCurriculumFormData,
      {
        ...courseCurriculumInitialFormData[0],
      },
    ]);
  }

  function handleCourseTitleChange(e, currentIndex) {
    let cpyCourseCurriculumFormData = [...courseCurriculumFormData];
    cpyCourseCurriculumFormData[currentIndex] = {
      ...cpyCourseCurriculumFormData[currentIndex],
      title: e.target.value,
    };
    setCourseCurriculumFormData(cpyCourseCurriculumFormData);
  }

  console.log(courseCurriculumFormData);

  function handleFreePreviewChange(currentValue, currentIndex) {
    let cpyCourseCurriculumFormData = [...courseCurriculumFormData];
    cpyCourseCurriculumFormData[currentIndex] = {
      ...cpyCourseCurriculumFormData[currentIndex],
      freePreview: currentValue,
    };
    setCourseCurriculumFormData(cpyCourseCurriculumFormData);
    console.log(currentValue, currentIndex);
  }

  async function handleSingleLectureUpload(e, currentIndex) {
    console.log(e.target.files);
    const selectedFile = e.target.files[0];

    if (selectedFile) {
      const videoFormData = new FormData();
      videoFormData.append("file", selectedFile);

      try {
        setMediaUploadProgress(true);
        const response = await mediaUploadService(videoFormData);
        console.log(response, "response");

        if (response.success) {
          let cpyCourseCurriculumFormData = [...courseCurriculumFormData];
          cpyCourseCurriculumFormData[currentIndex] = {
            ...cpyCourseCurriculumFormData[currentIndex],
            videoUrl: response?.data?.url, //this depends on how the response is sent from the backend
            public_id: response?.data?.public_id //this depends on how the response is sent from the backend
          }
          setCourseCurriculumFormData(cpyCourseCurriculumFormData);
          setMediaUploadProgress(false)
        }
      } catch (error) {
        console.log(error);
      }
    }
  }

  return (
    <Card>
      <CardHeader>
        <CardTitle>Create Course Curriculum</CardTitle>
      </CardHeader>
      <CardContent>
        <Button onClick={handleNewLecture}>Add Lecture</Button>
        <div className="space-y-6">
          {courseCurriculumFormData.map((curriculumItem, index) => (
            <div
              key={index}
              className="border rounded-xl p-4 shadow-sm bg-white space-y-4"
            >
              <div className="flex items-center justify-between">
                <h3 className="text-lg font-semibold text-gray-800">
                  Lecture {index + 1}
                </h3>
                <div className="flex items-center space-x-2">
                  <Switch
                    id={`freePreview-${index + 1}`}
                    checked={courseCurriculumFormData[index]?.freePreview}
                    onCheckedChange={(value) =>
                      handleFreePreviewChange(value, index)
                    }
                  />
                  <Label
                    htmlFor={`freePreview-${index + 1}`}
                    className="text-sm font-medium"
                  >
                    Free Preview
                  </Label>
                </div>
              </div>
              <div>
                <Input
                  name={`title-${index + 1}`}
                  placeholder="Enter lecture title"
                  className="w-full"
                  onChange={(e) => handleCourseTitleChange(e, index)}
                  value={courseCurriculumFormData[index]?.title}
                />
              </div>
              <div>
                <Input
                  type={"file"}
                  accept="video/*"
                  onChange={(e) => handleSingleLectureUpload(e, index)}
                  className={"mb-4 mt-6"}
                />
              </div>
            </div>
          ))}
        </div>
      </CardContent>
    </Card>
  );
}
