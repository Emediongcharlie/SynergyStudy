import { BarChart, Book, LogOut } from "lucide-react";
import React, { useContext, useState } from "react";
import AdminDashboard from "@/components/admin-view/dashboard";
import AdminCourses from "@/components/admin-view/courses";
import { Button } from "@/components/ui/button";
import { Tabs, TabsContent } from "@/components/ui/tabs";
import { AuthContext } from "@/context/authContext";

export default function AdminDashboardPage() {
  const [activeTab, setActiveTab] = useState("dashboard");
  const { logout } = useContext(AuthContext);

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
      component: <AdminCourses />,
    },
    {
      icon: LogOut,
      label: "Logout",
      value: "logout",
      component: null,
    },
  ];

  function handleLogout() {
    logout();
    sessionStorage.clear();
  }

  return (
    <div className="flex h-full min-h-screen bg-gray-100">
      <aside className="w-64 bg-white shadow-md hidden md:block">
        <div className="p-4 ">
          <h2 className="text-2xl font-bold mb-4">Admin View</h2>
          <nav>
            {menuItems.map((item) => (
              <Button
                key={item.value}
                variant={activeTab === item.value ? "secondary" : "ghost"}
                className="w-full mb-2 flex items-center justify-start"
                onClick={
                  item.value === "logout"
                    ? handleLogout
                    : () => setActiveTab(item.value)
                }
              >
                <item.icon className="mr-2 h-4 w-4" />
                {item.label}
              </Button>
            ))}
          </nav>
        </div>
      </aside>
      <main className="flex-1 p-8 overflow-y-auto">
        <div className="max-w-7xl mx-auto">
          <h1 className="text-3xl font-bold mb-8">Dashboard</h1>
          <Tabs value={activeTab} onValueChange={setActiveTab}>
            {menuItems.map((item) => (
              <TabsContent value={item.value} key={item.value}>
                {item.component !== null ? item.component : null}
              </TabsContent>
            ))}
          </Tabs>
        </div>
      </main>
    </div>
  );
}
