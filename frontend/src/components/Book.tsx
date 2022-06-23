import {BookData} from "../utils/utils";

export default function Book(data: BookData) {
    return(
        <div>
            <ul>
                <li>{data.id}</li>
                <li>{data.name}</li>
                <li>{data.available}</li>
                <li>{JSON.stringify(data.authors)}</li>
                <li>{JSON.stringify(data.department)}</li>
            </ul>
        </div>
    )
}