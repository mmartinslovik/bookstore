import {AuthorData, BookData} from "./BooksLoader";
import {useEffect, useState} from "react";
import axios from "axios";
import {useParams} from "react-router-dom";
import AuthorLoader from "./AuthorLoader";
import bookImage from 'book.png';

export default function SingleBookLoader() {
    const [book, setBook] = useState<BookData | any>([])
    const { id } = useParams()

    useEffect(() => {
        axios
            .get(`http://localhost:8080/books/${id}`)
            .then(response => {
                console.log("RESPONSE", response.data)
                const bookData: BookData = response.data
                setBook(bookData)
            })
    }, [])

    return (
        <div
            className="p-10 flex flex-col items-center text-center group md:lg:xl:border-r md:lg:xl:border-b hover:bg-slate-50 cursor-pointer">
                    <span className="p-5 rounded-full bg-emerald-500 text-white shadow-lg shadow-red-200">
                          <img
                              src={'book.png'}
                              alt={book.name}
                              width="120"
                          />
                    </span>
            <p className="text-xl font-medium text-slate-700 mt-3">
                {book.name}
            </p>
            <table className="table-auto mb-2">
                <tbody>
                <tr className="border-b">
                    <td className="text-sm text-gray-900 font-medium px-6 py-4 whitespace-nowrap">
                        Author(s):
                    </td>
                    <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                        {book.authors?.length > 0 ? book.authors?.map((a: AuthorData) => <AuthorLoader {...a} />)
                            : <>No authors</>}
                    </td>
                </tr>
                <tr className="border-b">
                    <td className="text-sm text-gray-900 font-medium px-6 py-4 whitespace-nowrap">
                        Department
                    </td>
                    <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                        {book.department?.name ? book.department?.name
                            : <>No department</>}
                    </td>
                </tr>
                </tbody>
            </table>
            <button
                type="button"
                className="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
            >
                Add to cart
            </button>
        </div>
    )
}