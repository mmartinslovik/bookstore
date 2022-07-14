import {AuthorData} from "./BooksLoader";

export default function AuthorLoader(author: AuthorData) {
    return (
        <h4 className="text-gray-900 font-semibold text-l tracking-tight dark:text-white">
            {author?.firstName} {author?.lastName}
        </h4>
    )
}