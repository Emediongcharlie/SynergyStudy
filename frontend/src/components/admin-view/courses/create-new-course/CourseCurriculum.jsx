import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Switch } from "@/components/ui/switch";
import { AdminContext } from "@/context/admin-context";
import React, { useContext } from "react";

export default function CourseCurriculum() {
  const { courseCurriculumFormData, setCourseCurriculumFormData } =
    useContext(AdminContext);

  return (
    <Card>
      <CardHeader>
        <CardTitle>Create Course Curriculum</CardTitle>
      </CardHeader>
      <CardContent>
        <Button>Add Lecture</Button>
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
                  <Switch id={`freePreview-${index + 1}`} checked={true} />
                  <Label
                    htmlFor={`freePreview-${index + 1}`}
                    className="text-sm font-medium"
                  >
                    Free Preview
                  </Label>
                </div>
              </div>

              <Input
                name={`title-${index + 1}`}
                placeholder="Enter lecture title"
                className="w-full"
              />
            </div>
          ))}
        </div>
      </CardContent>
    </Card>
  );
}
