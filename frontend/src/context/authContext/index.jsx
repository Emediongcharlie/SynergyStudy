import { Skeleton } from "@/components/ui/skeleton";
import { initialLoginFormData, initialRegisterFormData } from "@/config";
import { checkAuthService, loginService, registerService } from "@/services";
import { createContext, useEffect, useState } from "react";

// eslint-disable-next-line
export const AuthContext = createContext(null);

export default function AuthProvider({ children }) {
  const [loginFormData, setLoginFormData] = useState(initialLoginFormData);
  const [registerFormData, setRegisterFormData] = useState(
    initialRegisterFormData
  );
  const [auth, setAuth] = useState({
    authenticate: false,
    user: null,
  });
  const [loading, setLoading] = useState(true);

  async function handleRegister(e) {
    e.preventDefault();
    const data = await registerService(registerFormData);
    console.log("Registration successful:", data);
  }

  async function handleLogin(e) {
    e.preventDefault();
    const data = await loginService(loginFormData);
    console.log("Login successful:", data);

    if (data.success) {
      sessionStorage.setItem("accessToken", JSON.stringify(data.accessToken));

      setAuth({
        authenticate: true,
        user: data.user,
      });
    } else {
      setAuth({
        authenticate: false,
        user: null,
      });
    }
  }

  //to check if user is authenticated
  useEffect(() => {
    async function checkAuth() {
      try {
        const data = await checkAuthService();

        if (data.success) {
          setAuth({
            authenticate: true,
            user: data.user,
          });
          setLoading(false);
        } else {
          setAuth({
            authenticate: false,
            user: null,
          });
          setLoading(false);
        }
      } catch (error) {
        console.log("Error checking authentication:", error);
        if (error?.response?.data?.success === "false") {
          setAuth({
            authenticate: false,
            user: null,
          });
          setLoading(false);
        }
      }
    }
    checkAuth();
  }, []);

  console.log("Auth Context:", auth);

  return (
    <AuthContext.Provider
      value={{
        loginFormData,
        setLoginFormData,
        registerFormData,
        setRegisterFormData,
        handleRegister,
        handleLogin,
        auth,
      }}
    >
      {
        // loading ? <Skeleton /> :
        children
      }
    </AuthContext.Provider>
  );
}
