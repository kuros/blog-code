import {Book} from "../../components/book/BookPage";
import {BookActionType, CREATE_BOOK} from "./bookActionType";

export default function BookReducer(state: Book[] = [], action: BookActionType): Book[] {
    switch (action.type) {
        case CREATE_BOOK:
            return [...state, {...action.payload}];
        default:
            return state;
    }
}