import {BookData, AuthorData} from "./BooksLoader";
import AuthorLoader from "./AuthorLoader";
import {useNavigate} from "react-router-dom";

export default function BookCard(book: BookData) {
    let navigate = useNavigate();

    const routeChange = () => {
        let path = `/books/${(book.id).toString()}`;
        navigate(path);
    }
    return (
        <div
            onClick={routeChange}
            className="p-10 flex flex-col items-center text-center group md:lg:xl:border-r md:lg:xl:border-b hover:bg-slate-50 cursor-pointer">
                    <span className="p-5 rounded-full bg-red-500 text-white shadow-lg shadow-red-200">
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
                </tbody>
            </table>
        </div>
    )
}