import {
  BarChart,
  Bell,
  Book,
  HelpCircle,
  LogOut,
  MessageCircle,
  Settings,
  User,
  Users,
} from "lucide-react";
import React, { useContext, useEffect, useState } from "react";
import AdminDashboard from "@/components/admin-view/dashboard";
import AdminCourses from "@/components/admin-view/courses";
import { Button } from "@/components/ui/button";
import { Tabs, TabsContent } from "@/components/ui/tabs";
import { AuthContext } from "@/context/authContext";
import { AdminContext } from "@/context/admin-context";
import { fetchAdminCourseListService } from "@/services";

export default function AdminDashboardPage() {
  const [activeTab, setActiveTab] = useState("dashboard");
  const { logout } = useContext(AuthContext);
  const { adminCoursesList, setAdminCoursesList } = useContext(AdminContext);

  async function fetchAllCourses() {
    const response = await fetchAdminCourseListService();

    console.log(response);
    if (response?.success) setAdminCoursesList(response?.data);
  }

  useEffect(() => {
    fetchAllCourses();
  }, []);

  const menuItems = [
    {
      icon: BarChart,
      label: "Dashboard",
      value: "dashboard",
      component: <AdminDashboard />,
    },
    {
      icon: Book,
      label: "Courses",
      value: "courses",
      component: <AdminCourses listOfCourses={adminCoursesList} />,
    },
    {
      icon: MessageCircle,
      label: "Message",
      value: "message",
      component: null,
    },
    {
      icon: Bell,
      label: "Notification",
      value: "notification",
      component: null,
    },
    {
      icon: Users,
      label: "Students",
      value: "students",
      component: null,
    },
    {
      icon: User,
      label: "Instructors",
      value: "instructors",
      component: null,
    },
    {
      icon: LogOut,
      label: "LogOut",
      value: "logout",
      component: null,
    },
  ];

  function handleLogout() {
    logout();
    sessionStorage.clear();
  }

  return (
    <div className="flex min-h-screen bg-white">
      <aside className="w-64 bg-white text-black shadow-lg hidden md:flex flex-col">
        <div className="p-6 border-b border-gray-700">
          <h2 className="text-lg font-bold">SynergyStudy</h2>
        </div>

        <nav className="flex-1 p-4 space-y-2">
          {menuItems.map((item) => (
            <Button
              key={item.value}
              variant="ghost"
              className={`w-full justify-start px-4 py-3 rounded-lg text-sm font-medium transition-all ${
                activeTab === item.value
                  ? " bg-gray-300 text-black hover:bg-gray-300"
                  : "bg-transparent text-black hover:bg-gray-300 hover:text-black"
              }`}
              onClick={
                item.value === "logout"
                  ? handleLogout
                  : () => setActiveTab(item.value)
              }
            >
              <item.icon className="mr-3 h-5 w-5" />
              {item.label}
            </Button>
          ))}
        </nav>

        <div className="mt-auto border-t border-gray-700 p-4 space-y-2">
          <Button
            variant="ghost"
            className="w-full justify-start  text-black hover:bg-gray-300"
          >
            <Settings className="mr-3 h-5 w-5" /> Settings
          </Button>
          <Button
            variant="ghost"
            className="w-full justify-start  text-black hover:bg-gray-300"
          >
            <HelpCircle className="mr-3 h-5 w-5" /> Help Center
          </Button>
        </div>
      </aside>

      <main className="flex-1 p-6 md:p-10 overflow-y-auto bg-gray-100">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-8">
          <div className="bg-[#0B1120] text-white rounded-lg p-6 text-center">
            <h3 className="text-lg">Total Active Courses</h3>
            <p className="text-2xl font-bold">3</p>
          </div>
          <div className="bg-[#0B1120] text-white rounded-lg p-6 text-center">
            <h3 className="text-lg">Total Students</h3>
            <p className="text-2xl font-bold">432</p>
          </div>
          <div className="bg-[#0B1120] text-white rounded-lg p-6 text-center">
            <h3 className="text-lg">Total Courses</h3>
            <p className="text-2xl font-bold">3</p>
          </div>
        </div>

        <Tabs value={activeTab} onValueChange={setActiveTab}>
          {menuItems.map((item) => (
            <TabsContent value={item.value} key={item.value}>
              {item.component}
            </TabsContent>
          ))}
        </Tabs>
      </main>
    </div>
  );
}
