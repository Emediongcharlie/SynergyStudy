import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import React from "react";
import { useNavigate } from "react-router-dom";

export default function AdminCourses() {
  const navigate = useNavigate();

  return (
    <Card>
      <CardHeader className="flex items-center justify-between">
        <CardTitle className={"text-2xl font-bold"}>All Courses</CardTitle>
        <Button
          className={"hover:cursor-pointer"}
          onClick={() => {
            navigate("/admin/create-course");
          }}
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
              <TableRow>
                <TableCell className="font-medium">React</TableCell>
                <TableCell>100</TableCell>
                <TableCell>#20,000</TableCell>
                <TableCell className="text-right">
                  <Button
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
            </TableBody>
          </Table>
        </div>
      </CardContent>
    </Card>
  );
}
