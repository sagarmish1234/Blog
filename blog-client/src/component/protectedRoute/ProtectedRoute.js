import React, { useContext } from "react";
import { useLocation } from "react-router";
import { Navigate} from "react-router-dom";
function ProtectedRoute({ children }) {
  const user = sessionStorage.getItem("userDetails");
  return user? (
    children
  ) : (
    <Navigate
      to="/login"
      replace
      state={{
        from: window.location.pathname,
      }}
    />
  );
}

export default ProtectedRoute;
