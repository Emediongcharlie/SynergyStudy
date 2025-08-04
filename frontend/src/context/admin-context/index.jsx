import { courseLandingInitialFormData } from "@/config";
import { createContext, useState } from "react";

export const AdminContext = createContext(null);

export default function AdminProvider({ children }) {
  const [courseLandingFormData, setCourseLandingFormData] = useState(
    courseLandingInitialFormData
  );

  return (
    <AdminContext.Provider
      value={{ courseLandingFormData, setCourseLandingFormData }}
    >
      {children}
    </AdminContext.Provider>
  );
}
