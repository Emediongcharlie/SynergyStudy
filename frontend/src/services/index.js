import axiosInstance from "@/api/axiosInstance";

export async function registerService(formData) {
  const data = await axiosInstance.post("/register", {
    ...formData,
    role: "student", // Default role set to student, can be changed based on requirements
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

export async function mediaUploadService(formData, onProgressCallback) {
  const data = await axiosInstance.post("/media/upload", formData, {
    onUploadProgress: (progressEvent) => {
      const percentCompleted = Math.round(
        (progressEvent.loaded * 100) / progressEvent.total
      );
      onProgressCallback(percentCompleted);
    },
  }); // depends on the backend API implementation

  return data.data;
}

export async function addNewCourseService(formData) {
  const data = await axiosInstance.post("/admin/course/add", formData); // depends on the backend API implementation

  return data.data;
}

export async function fetchAdminCourseListService() {
  const data = await axiosInstance.get("/admin/course/get"); // depends on the backend API implementation

  return data.data;
}

export async function fetchAdminCourseDetailsService(id) {
  const data = await axiosInstance.get(`/admin/course/details/${id}`); // depends on the backend API implementation

  return data.data;
}

export async function fetchInstructorCourseListService() {
  const data = await axiosInstance.get("/instructor/course/get"); // depends on the backend API implementation

  return data.data;
}

export async function fetchInstructorCourseDetailsService(id) {
  const data = await axiosInstance.get(`/instructor/course/details/${id}`); // depends on the backend API implementation

  return data.data;
}

export async function updateCourseByIdService(id, formData) {
  const data = await axiosInstance.put(`/admin/course/update/${id}`, formData); // depends on the backend API implementation

  return data.data;
}
