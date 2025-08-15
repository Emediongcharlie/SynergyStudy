import { Route, Routes } from "react-router-dom";
import "./App.css";
import AuthPage from "./pages/auth";
import StudentHomepage from "./pages/student/home";
import ProtectedRoute from "./components/protected-route";
import { useContext } from "react";
import { AuthContext } from "./context/authContext";
import StudentViewLayout from "./components/student-view/CommonLayout";
import NotFound from "./pages/not-found";
import CreateCourse from "./pages/admin/CreateCourse";
import InstructorDashboard from "./components/instructor-view/dashboard";
import AdminDashboard from "./components/admin-view/dashboard";
import AdminDashboardPage from "./pages/admin";
import InstructorDashboardPage from "./pages/instructor";
import InstructorCreateCourse from "./pages/instructor/InstructorCreateCourse";

function App() {
  const { auth } = useContext(AuthContext);

  return (
    <>
      <Routes>
        <Route path="/auth" element={<AuthPage />} />
        <Route path="/admin" element={<AdminDashboardPage />} />
        <Route path="/admin/create-course" element={<CreateCourse />} />
        <Route path="/admin/edit-course/:courseId" element={<CreateCourse />} />
        <Route path="/instructor" element={<InstructorDashboardPage />} />
        <Route
          path="/instructor/create-course"
          element={<InstructorCreateCourse />}
        />
        <Route path="/student" element={<StudentHomepage />} />
        <Route path="/" element={<StudentViewLayout />} />
        <Route path="/home" element={<StudentHomepage />} />
        <Route path="*" element={<NotFound />} />

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
              element={<AdminDashboardPage />}
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
          path="/admin/edit-course/:courseId"
          element={
            <ProtectedRoute
              element={<CreateCourse />}
              authenticated={auth?.authenticate}
              user={auth?.user}
            />
          }
        />

        <Route
          path="/instructor"
          element={
            <ProtectedRoute
              element={<InstructorDashboardPage />}
              authenticated={auth?.authenticate}
              user={auth?.user}
            />
          }
        />

        <Route
          path="/instructor/create-course"
          element={
            <ProtectedRoute
              element={<InstructorCreateCourse />}
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
          <Route path="/" element={<StudentHomepage />} />
          <Route path="/home" element={<StudentHomepage />} />
        </Route>

        <Route path="*" element={<NotFound />} /> */}
      </Routes>
    </>
  );
}

export default App;
