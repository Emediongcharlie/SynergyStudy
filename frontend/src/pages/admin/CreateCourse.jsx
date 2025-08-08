import CourseCurriculum from "@/components/admin-view/courses/create-new-course/CourseCurriculum";
import CourseLanding from "@/components/admin-view/courses/create-new-course/CourseLanding";
import CourseSettings from "@/components/admin-view/courses/create-new-course/CourseSettings";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@radix-ui/react-tabs";
import React from "react";

export default function CreateCourse() {
  return (
    <div className="container mx-auto p-6 space-y-6">
      {/* Header with title and submit button */}
      <div className="flex items-center justify-between">
        <h1 className="text-3xl font-semibold tracking-tight">
          Create a New Course
        </h1>
        <Button className="text-sm tracking-wide font-semibold px-6 py-2">
          Submit
        </Button>
      </div>

      {/* Card with tabs */}
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
