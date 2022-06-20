import React, {useEffect, useState} from 'react';
import './App.css';
import axios from "axios";

function App() {
  const [books, setBooks] = useState(null)

  useEffect(() => {
    axios.get("/books").then(response => {
      setBooks(response.data)
    })
  }, [])

  if (!books) return null

  return (
    <div>
      {JSON.stringify(books)}
    </div>
  );
}

export default App;
