import {useContext, useState} from 'react'
import {BookData, AuthorData} from "./BooksLoader";
import AuthorLoader from "./AuthorLoader";

export default function BookCard(book: BookData) {
    return (
        <div className="max-w-2xl mx-auto m-4 p-4">
            <div className="bg-white shadow-md rounded-lg max-w-sm dark:bg-gray-800 dark:border-gray-700">
                <div className="px-5 pb-5">
                    <a href="#">
                        <h3 className="text-gray-900 font-semibold text-xl tracking-tight dark:text-white">
                            {book.name}
                        </h3>
                        {book.authors.length > 0 ? book.authors?.map((a: AuthorData) => <AuthorLoader {...a} />)
                        : <div>No authors</div>}
                        <h4 className="text-gray-900 font-semibold text-l tracking-tight dark:text-white">

                        </h4>
                        <h4 className="text-gray-900 font-semibold text-l tracking-tight dark:text-white">
                            {book.department?.name}
                        </h4>
                    </a>
                    <div className="flex items-center justify-between">
                        <span className="text-3xl font-bold text-gray-900 dark:text-white">{book.price}€</span>
                        <a href="#"
                           className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Add
                            to cart</a>
                    </div>
                </div>
            </div>
        </div>
    )
}