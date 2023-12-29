import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '/node_modules/bootstrap/dist/js/bootstrap.min.js'
import './App.css';
import { StudentsView } from './component/student/StudentsView';
import NavBar from './component/common/NavBar'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import { Home } from './home';
import AddStudent from './component/student/AddStudent';
import EditStudent from './component/student/EditStudent';
import StudentProfile from './component/student/StudentProfile';

function App() {
  return (
    <main className="container mt-4">
        <Router>
          <NavBar />
          <Routes>
            <Route path='/' element={<Home />}/>
            <Route path='/view-students' element={<StudentsView />}/>
            <Route path='/add-students' element={<AddStudent />}/>
            <Route path='/edit-student/:id' element={<EditStudent />} />
            <Route path='/student-profile/:id' element={<StudentProfile />} />
          </Routes>
        </Router>
        

    </main>
  );
}

export default App;
