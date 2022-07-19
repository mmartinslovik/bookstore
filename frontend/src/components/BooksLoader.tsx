import {useEffect, useState} from "react";
import axios from "axios";
import BookCard from "./BookCard";

export interface BookData {
    id: bigint
    name: string
    available: boolean
    price: number
    authors: AuthorData[] | []
    department: {
        id: bigint
        name: string
    } | null
}

export interface AuthorData {
    id: bigint
    firstName: string
    lastName: string
}

export default function BooksLoader() {
    const [data, setData] = useState<BookData[] | any>([])

    useEffect(() => {
        axios
            .get("http://localhost:8080/books")
            .then(response => {
                const bookList: BookData[] = response.data._embedded.bookList
                setData(bookList)
            })
    }, [])

    return (
        <div className="px-3 md:lg:xl:px-40   border-t border-b py-20 bg-opacity-10">
            <div className="grid grid-cols-1 md:lg:xl:grid-cols-3 group bg-white shadow-xl shadow-neutral-100 border ">
                {data ? data.map((item: BookData) => <BookCard {...item} />) : <div>No books</div>}
            </div>
        </div>
    )
}