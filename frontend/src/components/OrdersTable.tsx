import {useEffect, useState} from "react";
import axios from "axios";
import {AuthorData, BookData} from "./BooksLoader";
import useToken from "../utils/useToken";
import {IUserData} from "./Navbar";
import OrdersTableRow from "./OrdersTableRow";

export interface IUserOrderData {
    id: bigint
    description: string
    status: string
    books: BookData[]
    user: IUserData
}

export default function OrdersTable() {
    const [orders, setOrders] = useState<IUserOrderData[] | any>([])
    const {token, setToken} = useToken();
    const [user, setUser] = useState<IUserData>()

    useEffect(() => {
        axios
            .get("http://localhost:8080/orders/", {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            })
            .then(response => {
                const userOrderData: IUserOrderData[] = response.data._embedded.orderList
                setOrders(userOrderData)
                setUser(response.data._embedded.orderList[0].user)
            })
    }, [])

    return (
        <div className="m-4 p-10 flex flex-col items-center text-center group md:lg:xl:border-r md:lg:xl:border-b hover:bg-slate-50 cursor-pointer">
            <p className="text-xl font-medium text-slate-700 my-3">
                {user?.email}
            </p>
            <table className="table-auto mb-2">
                <thead>
                <tr className="border">
                    <th className="text-sm text-gray-900 font-bold px-6 py-4 whitespace-nowrap">
                        Id
                    </th>
                    <th className="text-sm text-gray-900 font-bold px-6 py-4 whitespace-nowrap">
                        Book(s)
                    </th>
                    <th className="text-sm text-gray-900 font-bold px-6 py-4 whitespace-nowrap">
                        Description
                    </th>
                    <th className="text-sm text-gray-900 font-bold px-6 py-4 whitespace-nowrap">
                        Price
                    </th>
                    <th className="text-sm text-gray-900 font-bold px-6 py-4 whitespace-nowrap">
                        Status
                    </th>
                </tr>
                </thead>
                <tbody>
                    {orders.map((o: IUserOrderData) => <OrdersTableRow {...o} />)}
                </tbody>
            </table>
        </div>
    )
}