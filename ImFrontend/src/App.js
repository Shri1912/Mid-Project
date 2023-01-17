
import { Route, Routes } from 'react-router-dom';
import './App.css';
import AddProduct from './component/AddProduct';
import EditProduct from './component/EditProduct';
import Home from './component/Home';
import Login from './Login';
import Navbar from './component/Navbar';
import SignUp from './Signup';

function App() {
  return (
    <>
      <Navbar/>

      <Routes>
      <Route path="" element={<Login />}></Route>
        <Route path="/signup" element={<SignUp/>}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/home" element={<Home />}></Route>
        
        <Route path='/addProduct' element={<AddProduct/>}></Route>
        <Route path='/editProduct/:id' element={<EditProduct/>}></Route>

      </Routes>
    </>

  );
}

export default App;

/*function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path="" element={<Login />}></Route>
        <Route path="/signup" element={<SignUp />}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/home" element={<Home />}></Route>
      </Routes>
    </BrowserRouter>
    </>  
    

  );
}*/

/*<Route path='/' element={<Home/>}></Route>
import Login from './component/Login';
import Navbar from './component/Navbar';
import SignUp from './component/SignUp';
*/