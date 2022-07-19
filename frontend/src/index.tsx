import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Navbar} from "./components/Navbar";
import BooksLoader from "./components/BooksLoader";
import SingleBookLoader from "./components/SingleBookLoader";
import Order from "./components/Order";

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
      <BrowserRouter>
          <Navbar />
          <Routes>
              <Route path="/" element={ <App /> } />
              <Route path="/books" element={ <BooksLoader /> } />
              <Route path="/books/:id" element={ <SingleBookLoader /> } />
              <Route path="/orders" element={ <Order /> } />
          </Routes>
      </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
