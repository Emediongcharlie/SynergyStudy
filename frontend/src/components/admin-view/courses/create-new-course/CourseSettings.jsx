import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { AdminContext } from "@/context/admin-context";
import { mediaUploadService } from "@/services";
import React, { useContext } from "react";

export default function CourseSettings() {
  const { courseLandingFormData, setCourseLandingFormData } =
    useContext(AdminContext);

  async function handleImageUploadChange(e) {
    const selectedImage = e.target.files[0];

    if (selectedImage) {
      const imageFormData = new FormData();
      imageFormData.append("file", selectedImage);

      try {
        const response = await mediaUploadService(imageFormData);

        console.log(response, "response"); //to check the response data sent from the backend
        if (response.success) {
          setCourseLandingFormData({
            ...courseLandingFormData,
            image: response.data.url, //this .data.url depends on the format the backend used to send the image
          });
        }
      } catch (error) {
        console.log(error);
      }
    }
  }

  return (
    <Card>
      <CardHeader>
        <CardTitle>Course Thumbnail</CardTitle>
      </CardHeader>
      <CardContent>
        {courseLandingFormData?.image ? (
          <img src={courseLandingFormData.image} alt="" />
        ) : (
          <div className="flex flex-col gap-3">
            <Label>Upload Course Image/Thumbnail</Label>
            <Input
              onChange={handleImageUploadChange}
              type={"file"}
              accept="image/*"
            ></Input>
          </div>
        )}
      </CardContent>
    </Card>
  );
}
