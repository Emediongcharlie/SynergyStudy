import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:5000/api", // Adjust the base URL as needed from the backend
});

axiosInstance.interceptors.request.use(
  (config) => {
    const accessToken = JSON.parse(sessionStorage.getItem("accessToken")) || ''; // Retrieve the access token from session storage


    // If the access token exists, attach it to the request headers
    if (accessToken) {
      config.headers["Authorization"] = `Bearer ${accessToken}`; // Attach the token to the request headers
    }
    return config;
  },
  (error) => Promise.reject(error)
);

export default axiosInstance;
