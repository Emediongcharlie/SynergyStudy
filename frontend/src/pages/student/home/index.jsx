import { Button } from "@/components/ui/button";
import { AuthContext } from "@/context/authContext";
import React, { useContext } from "react";

export default function StudentHomepage() {
  const { logout } = useContext(AuthContext);

  function handleLogout() {
    logout();
    sessionStorage.clear();
  }

  return (
    <div>
      Student Homepage
      <Button onClick={handleLogout}>Logout</Button>
    </div>
  );
}
