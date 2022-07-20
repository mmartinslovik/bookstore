import {IUserOrderData} from "./OrdersTable";
import {number} from "zod";
import {AuthorData, BookData} from "./BooksLoader";

export default function OrdersTableRow(orderData: IUserOrderData) {
    let price = 0
    orderData.books.forEach((b: BookData) => {
        price += b.price
    })

    return (
        <>
            <tr className="border-b">
                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {Number(orderData.id)}
                </td>
                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {orderData.books.map((b: BookData) => b.name)}
                </td>
                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {orderData.description}
                </td>
                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {price}
                </td>
                <td className="text-sm text-gray-900 font-light px-6 py-4 whitespace-nowrap">
                    {orderData.status}
                </td>
            </tr>
        </>
    )
}