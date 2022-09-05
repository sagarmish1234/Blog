import { createContext, useState } from "react";
import { Routes, Route, useLocation } from "react-router-dom";
import Navbar from "./component/navbar/Navbar";
import Article from "./pages/Article/Article";
import Home from "./pages/home/Home";
import Login from "./component/login/Login";
import Signup from "./component/signup/Signup";
import { AnimatePresence } from "framer-motion";
import Categories from "./pages/categories/Categories";
import ProtectedRoute from "./component/protectedRoute/ProtectedRoute";

export const UserDetails = createContext(null);

function App() {
  const [userDetials, setUserDetails] = useState(null);
  const location = useLocation();
  return (
    <>
      <UserDetails.Provider value={[userDetials, setUserDetails]}>
        <Navbar></Navbar>
        <AnimatePresence exitBeforeEnter>
          <Routes
            onUpdate={() => window.scrollTo(0, 0)}
            key={location.pathname}
            location={location}
          >
            <Route path="/" element={<Home />}></Route>
            <Route path="article/*" element={<Article />}></Route>
            <Route path="/login" element={<Login />}></Route>
            <Route path="/register" element={<Signup />}></Route>
            <Route
              path="/categories"
              element={
                <ProtectedRoute>
                  <Categories />
                </ProtectedRoute>
              }
            ></Route>
          </Routes>
        </AnimatePresence>
      </UserDetails.Provider>
    </>
  );
}

export default App;
