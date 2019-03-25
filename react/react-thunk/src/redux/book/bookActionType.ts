import {Book} from "../../components/book/BookPage";

export const CREATE_BOOK = 'CREATE_BOOK';

interface CreateBookAction {
    type: typeof CREATE_BOOK
    payload: Book
}

export type BookActionType = CreateBookAction;