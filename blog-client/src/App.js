import { Routes,Route } from "react-router-dom";
import Navbar from "./component/navbar/Navbar";
import Article from "./pages/Article/Article";
import Home from "./pages/home/Home";
function App() {
  return (
    <>
      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<Home/>}></Route>
        <Route path="article/*" element={<Article/>} ></Route>
      </Routes>
    </>
  );
}

export default App;
