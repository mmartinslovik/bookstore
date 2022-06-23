import React, {useEffect, useState} from 'react';
import './App.css';
import Books from "./components/Books";
import {Routes, Route} from "react-router-dom";


function App() {

    return (
        <Routes>
            <Route path="/books" element={<Books />} />
        </Routes>
    );
}

export default App;
