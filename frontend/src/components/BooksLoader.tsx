import {useEffect, useState, createContext} from "react";
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
                console.log("RESPONSE", response.data)
                const bookList: BookData[] = response.data._embedded.bookList
                setData(bookList)
            })
    }, [])

    return (
        <div className='container mx-auto p-4'>
            {data ? data.map((item: BookData) => <BookCard {...item} />) : <div>No books</div>}
        </div>
    )
}