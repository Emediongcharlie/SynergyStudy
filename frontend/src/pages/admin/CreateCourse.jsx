import CourseCurriculum from "@/components/admin-view/courses/create-new-course/CourseCurriculum";
import CourseLanding from "@/components/admin-view/courses/create-new-course/CourseLanding";
import CourseSettings from "@/components/admin-view/courses/create-new-course/CourseSettings";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@radix-ui/react-tabs";
import React from "react";

export default function CreateCourse() {
  return (
    <div className="container mx-auto p-4">
      <div className="flex justify-between">
        <h1 className="text-3xl font-bold mb-5">Create a new course</h1>
        <Button className={"text-sm tracking-wider font-bold px-8"}>
          Submit
        </Button>
      </div>
      <Card>
        <CardContent>
          <div>
            <Tabs defaultValue="curriculum">
              <TabsList>
                <TabsTrigger value="curriculum">Curriculum</TabsTrigger>
                <TabsTrigger value="course-landing-page">
                  Course Landing Page
                </TabsTrigger>
                <TabsTrigger value="settings">Settings</TabsTrigger>
              </TabsList>
              <TabsContent value="curriculum">
                <CourseCurriculum/>
              </TabsContent>
              <TabsContent value="course-landing-page">
                <CourseLanding/>
              </TabsContent>
              <TabsContent value="settings">
                <CourseSettings/>
              </TabsContent>
            </Tabs>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
