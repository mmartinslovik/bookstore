import {useEffect, useState} from "react";
import axios from "axios";
import Book from "./Book";
import {BookData} from "../utils/utils";

interface Data {
    _embedded: {
        bookList: [
            BookData
        ]
    },
    _links: {}
}

export default function Books() {
    const [data, setData] = useState<Data>()

    useEffect(() => {
        axios
            .get("/books")
            .then(response => {
                setData(response.data)
            })
    }, [])

    console.log(data)

    return(
        <div>
            {data ? data._embedded.bookList.map(book => <Book {...book} />)
                : <div>No books</div>}
        </div>
    )

}