import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { AdminContext } from "@/context/admin-context";
import React, { useContext } from "react";
import { useNavigate } from "react-router-dom";

export default function AdminCourses({ listOfCourses }) {
  const navigate = useNavigate();
  const { currentEditedCourseId, setCurrentEditedCourseId } =
    useContext(AdminContext);

  return (
    <Card>
      <CardHeader className="flex items-center justify-between">
        <CardTitle className={"text-2xl font-bold"}>All Courses</CardTitle>
        <Button
          className={"hover:cursor-pointer"}
          onClick={() => {
            navigate("/admin/create-course");
          }}
          // to check whether current edited course id is null or not:
          // onClick={() => { setCurrentEditedCourseId(null);
          // navigate("/admin/create-course")
          // }}
        >
          Create new course
        </Button>
      </CardHeader>
      <CardContent>
        <div className="overflow-x-auto">
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Course</TableHead>
                <TableHead>Students</TableHead>
                <TableHead>Revenue</TableHead>
                <TableHead className="text-right">Actions</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {listOfCourses && listOfCourses.length > 0
                ? listOfCourses.map((course) => (
                    <TableRow>
                      {/* the .title, .students, ..... depends on how it is been passed from the backend */}
                      <TableCell className="font-medium">
                        {course?.title}
                      </TableCell>
                      <TableCell>{course?.students?.length}</TableCell>
                      <TableCell>{course?.price}</TableCell>
                      <TableCell className="text-right">
                        <Button
                          onClick={() => {
                            navigate(`/admin/edit-course/${course?._id}`);
                          }}
                          variant="ghost"
                          size={"sm"}
                          className={"hover:bg-gray-500 cursor-pointer"}
                        >
                          Edit
                        </Button>
                        <Button
                          variant="destructive"
                          className="ml-2 hover:bg-red-900 cursor-pointer"
                          size={"sm"}
                        >
                          Delete
                        </Button>
                      </TableCell>
                    </TableRow>
                  ))
                : "You have no courses, add a course"}
            </TableBody>
          </Table>
        </div>
      </CardContent>
    </Card>
  );
}
