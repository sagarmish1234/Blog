import { createContext, useState } from "react";
import { Routes, Route } from "react-router-dom";
import Navbar from "./component/navbar/Navbar";
import Article from "./pages/Article/Article";
import Home from "./pages/home/Home";
import Login from "./component/login/Login";
import Signup from "./component/signup/Signup";
import { AnimatePresence } from "framer-motion";

export const ShowLogin = createContext(false);
export const ShowSignup = createContext(false);

function App() {
  const [showLogin, setShowLogin] = useState(false);
  const [showSignup, setShowSignup] = useState(false);
  return (
    <>
      <ShowSignup.Provider value={[showSignup, setShowSignup]}>
        <ShowLogin.Provider value={[showLogin, setShowLogin]}>
          <Navbar></Navbar>
          <Routes>
            <Route path="/" element={<Home />}></Route>
            <Route path="article/*" element={<Article />}></Route>
          </Routes>
          <AnimatePresence>
            {showLogin && <Login key="login"></Login>}
            {showSignup && <Signup key="signup"></Signup>}
          </AnimatePresence>
        </ShowLogin.Provider>
      </ShowSignup.Provider>
    </>
  );
}

export default App;
