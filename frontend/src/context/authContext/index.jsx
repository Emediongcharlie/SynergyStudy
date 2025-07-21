import { initialLoginFormData, initialRegisterFormData } from "@/config";
import { createContext, useState } from "react";


//first create context
// eslint-disable-next-line
export const AuthContext = createContext(null);

export default function AuthProvider({ children }) {
  const [loginFormData, setLoginFormData] = useState(initialLoginFormData);
  const [registerFormData, setRegisterFormData] = useState(
    initialRegisterFormData
  )

  return (
    <AuthContext.Provider value={{
      loginFormData,
      setLoginFormData,
      registerFormData,
      setRegisterFormData
    }}>
      {children}
    </AuthContext.Provider>
  )
}