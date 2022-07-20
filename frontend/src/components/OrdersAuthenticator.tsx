import Login from "./Login";
import OrdersTable from "./OrdersTable";
import useToken from "../utils/useToken";
import {useState} from "react";

export default function OrdersAuthenticator() {
    const {token, setToken} = useToken();

    return (
        <div>
            {token ? <OrdersTable /> : <Login setToken={setToken} />}
        </div>
    )
}