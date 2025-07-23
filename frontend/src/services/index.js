import axiosInstance from "@/api/axiosInstance";

export async function registerService(formData) {
  const data = await axiosInstance.post("/register", {
    ...formData,
    role: "user",
  }); // (/register) depends on the backend implementation

  return data.data;
}

export async function loginService(formData) {
  const data = await axiosInstance.post("/login", formData); // (/login) depends on the backend implementation

  return data.data;
}

export async function checkAuthService() {
  const data = await axiosInstance.get("/check-Auth"); // depends on the backend implementation

  return data.data;
}
