import {AuthorData} from "./BooksLoader";

export default function AuthorLoader(author: AuthorData) {
    return (
        <h4 className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
            {author?.firstName} {author?.lastName}
        </h4>
    )
}