import React, {useEffect, useState} from 'react';
import './App.css';
import axios from "axios";

function App() {
    const [books, setBooks] = useState(null)

    const handleBooks = () => {
        axios
            .get("/books")
            .then(response => {
                setBooks(response.data)
            })
    }

    return (
        <div>
            <h1 className="text-3xl font-bold underline">
                Hello world!
            </h1>
            <button onClick={() => handleBooks()}>GET BOOKS</button>
            {books && JSON.stringify(books)}
        </div>
    );
}

export default App;
