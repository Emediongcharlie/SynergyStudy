import CommonForm from "@/components/forms";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import { loginFormControls, registerFormControls } from "@/config";
import { AuthContext } from "@/context/authContext";
import { GraduationCap } from "lucide-react";
import React, { useContext, useState } from "react";
import { Link } from "react-router-dom";

export default function AuthPage() {
  const [activeTab, setActiveTab] = useState("login");

  const {
    loginFormData,
    setLoginFormData,
    registerFormData,
    setRegisterFormData,
  } = useContext(AuthContext);

  return (
    <div className="flex flex-col min-h-screen">
      <header className="px-4 lg:px-6 h-16 flex items-center justify-between">
        {/* Left side: Logo */}
        <Link to="/" className="flex items-center">
          <GraduationCap className="h-8 w-8 mr-2" />
          <span className="text-2xl font-bold">SynergyStudy</span>
        </Link>

        {/* Right side: Login/Register toggle */}
        <div className="text-sm">
          {activeTab === "login" ? (
            <span>
              Don't have an account?{" "}
              <button
                onClick={() => setActiveTab("register")}
                className="text-blue-600 hover:underline"
              >
                Register
              </button>
            </span>
          ) : (
            <span>
              Have an account?{" "}
              <button
                onClick={() => setActiveTab("login")}
                className="text-blue-600 hover:underline"
              >
                Login
              </button>
            </span>
          )}
        </div>
      </header>
      <div className="flex items-center justify-center min-h-screen bg-background">
        <Tabs
          value={activeTab}
          defaultValue="login"
          onValueChange={setActiveTab}
          className="w-full max-w-md"
        >
          <TabsList className={"grid w-full grid-cols-2"}>
            <TabsTrigger value="login"> Login</TabsTrigger>
            <TabsTrigger value="register">Register</TabsTrigger>
          </TabsList>
          <TabsContent value="login">
            <Card className={"p-5 space-y-4"}>
              <CardHeader
                className={"flex flex-col justify-center items-center"}
              >
                <CardTitle className={"text-2xl"}>Login</CardTitle>
                <CardDescription>
                  Enter your Username and password
                </CardDescription>
              </CardHeader>
              <CardContent className={"space-y-2"}>
                <CommonForm
                  formControls={loginFormControls}
                  buttonText={"Login"}
                  formData={loginFormData}
                  setFormData={setLoginFormData}
                  isButtonDisabled={
                    !loginFormData.email || !loginFormData.password
                  }
                />
              </CardContent>
            </Card>
          </TabsContent>
          <TabsContent value="register">
            <Card className={"p-5 space-y-4"}>
              <CardHeader className={"flex flex-col justify-center items-center"}>
                <CardTitle  className={"text-2xl"}>Create an account</CardTitle>
                <CardDescription>
                  Enter your details to create a new account
                </CardDescription>
              </CardHeader>
              <CardContent className={"space-y-2"}>
                <CommonForm
                  formControls={registerFormControls}
                  buttonText={"Register"}
                  formData={registerFormData}
                  setFormData={setRegisterFormData}
                  isButtonDisabled={
                    !registerFormData.fullname ||
                    !registerFormData.password ||
                    !registerFormData.email
                  }
                />
              </CardContent>
            </Card>
          </TabsContent>
        </Tabs>
      </div>
    </div>
  );
}
