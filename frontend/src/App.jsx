import { Route, Routes } from "react-router-dom";
import "./App.css";
import AuthPage from "./pages/auth";
import AdminDashboard from "./pages/admin";
import StudentHomepage from "./pages/student/home";
import ProtectedRoute from "./components/protected-route";
import { useContext } from "react";
import { AuthContext } from "./context/authContext";
import StudentViewLayout from "./components/student-view/CommonLayout";
import NotFound from "./pages/not-found";
import CreateCourse from "./pages/admin/CreateCourse";

function App() {
  const { auth } = useContext(AuthContext);

  return (
    <>
      <Routes>
        <Route path="/auth" element={<AuthPage />} />
        <Route path="/admin" element={<AdminDashboard />} />
        <Route path="/student" element={<StudentHomepage />} />
        <Route path="/" element={<StudentViewLayout />} />
        <Route path="/home" element={<StudentHomepage />} />
        <Route path="*" element={<NotFound />} />
        <Route path="/admin/create-course" element={<CreateCourse />} />

        {/* <Route
          path="/auth"
          element={
            <ProtectedRoute
              element={<AuthPage />}
              authenticated={auth?.authenticate}
              user={auth?.user}
            />
          }
        />

        <Route
          path="/admin"
          element={
            <ProtectedRoute
              element={<AdminDashboard />}
              authenticated={auth?.authenticate}
              user={auth?.user}
            />
          }
        />

        <Route
          path="/admin/create-course"
          element={
            <ProtectedRoute
              element={<CreateCourse />}
              authenticated={auth?.authenticate}
              user={auth?.user}
            />
          }
        />
        <Route
          path="/"
          element={
            <ProtectedRoute
              element={<StudentViewLayout />}
              authenticated={auth?.authenticate}
              user={auth?.user}
            />
          }
        >
          <Route path="/" element={<StudentHomepage/>} />
          <Route path="/home" element={<StudentHomepage/>} />
        </Route> */}
      </Routes>
    </>
  );
}

export default App;
