import { Button } from "@/components/ui/button";
import { courseCategories } from "@/config";
import { AuthContext } from "@/context/authContext";
import React, { useContext } from "react";

export default function StudentHomepage() {
  const { logout } = useContext(AuthContext);

  function handleLogout() {
    logout();
    sessionStorage.clear();
  }

  return (
    <div className="min-h-screen bg-white">
      <section classame="flex flex-col lg:flex-row items-center justify-between py-8 px-4 lg:px-8">
        <div className="lg:w-1/2 lg:pr-12">
          <img src="" alt="" width={600} />
          <h3 className="text-3xl font-bold mb-4 whitespace-nowrap">
            A Space to Learn and Grow
          </h3>
          <p>
            Changing careers or exploring something new? We believe in your
            potential
          </p>
        </div>
        <div className="lg:w-full mb-8 lg:mb-0">
          <img src="" alt="" width={600} />
        </div>
      </section>
      <section className="py-8 px-4 lg:px-8 bg-gray-100">
        <h2 className="text-2xl font-bold mb-6">Our Courses</h2>
        <div className="grid grid-cols-5 sm:grid-cols-3 md:grid-cols-5 gap-4">
          {courseCategories.map((category) => (
            <Button
              className={"justify-center"}
              variant={"outline"}
              key={category.id}
            >
              {category.label}
            </Button>
          ))}
        </div>
      </section>
    </div>
  );
}
