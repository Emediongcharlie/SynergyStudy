import { GraduationCap, TvMinimalPlay } from "lucide-react";
import React from "react";
import { Link, Navigate } from "react-router-dom";
import { Button } from "../ui/button";

export default function StudentViewHeader() {

  function handleLogout() {
    logout();
    sessionStorage.clear();
    <Navigate to='/auth' />
  }

  return (
    <header className="flex items-center justify-between p-4 border-b relative">
      <div className="flex items-center space-x-4">
        <Link to={"/home"} className="flex">
          <GraduationCap className="h-8 w-8 mr-4 hover:text-black" />
          <span className="font-bold md:text-xl text-[14px]">
            Synergy Study
          </span>
        </Link>
        <div className="flex items-center space-x-1">
          <Button
            variant={"ghost"}
            className={
              "text-[14px] md:text-[16px] font-medium cursor-pointer border border-black "
            }
          >
            All Courses
          </Button>
        </div>
      </div>
      <div className="flex items-center space-x-4">
        <div>
          <Button
            variant={"ghost"}
            className={
              "text-[14px] md:text-[16px] font-medium cursor-pointer border border-black "
            }
          >
            Home
          </Button>
        </div>
        <div>
          <Button
            variant={"ghost"}
            className={
              "text-[14px] md:text-[16px] font-medium cursor-pointer border border-black "
            }
          >
            Instruct on Synergy
          </Button>
        </div>
        <div className="flex gap-4 items-center">
          <TvMinimalPlay className="w-8 h-8 cursor-pointer" />
        </div>
        <Button onClick={handleLogout} >Logout</Button>
      </div>
    </header>
  );
}
