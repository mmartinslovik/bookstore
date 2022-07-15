import {useContext, useState} from 'react'
import {BookData, AuthorData} from "./BooksLoader";
import AuthorLoader from "./AuthorLoader";

export default function BookCard(book: BookData) {
    return (
        <div className="mx-auto m-4 p-4">
            <div className="bg-white shadow-md rounded-lg max-w-sm dark:bg-gray-800 dark:border-gray-700">
                <div className="p-5 pb-5">
                    <div className="flex justify-between px-8">
                        <div className="flex-col">
                            <img
                                src="./book.png"
                                alt={book.name}
                                width="120"
                            />
                            <h3 className="text-gray-900 font-semibold text-3xl tracking-tight dark:text-white">
                                {book.name}
                            </h3>
                        </div>
                        <div className="flex-col">
                            <h4 className="text-gray-900 font-semibold text-l tracking-tight dark:text-white">
                                Author(s):
                            </h4>
                            {book.authors.length > 0 ? book.authors?.map((a: AuthorData) => <AuthorLoader {...a} />) :
                                <div className="text-gray-900 font-semibold text-l tracking-tight dark:text-white">
                                    No authors
                                </div>}
                            <h4 className="mt-2 text-gray-900 font-semibold text-l tracking-tight dark:text-white">
                                Department:
                            </h4>
                            <h4 className="text-gray-900 font-semibold text-l tracking-tight dark:text-white">
                                {book.department?.name ? book.department?.name :
                                    <div className="text-gray-900 font-semibold text-l tracking-tight dark:text-white">
                                        No department
                                    </div>}
                            </h4>
                            <h3 className="text-2xl font-bold text-gray-900 dark:text-white mt-4 mb-2">{book.price}€</h3>
                            <a href="#"
                               className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Add
                                to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}