import {Book} from "../../components/book/BookPage";
import {BookActionType, CREATE_BOOK} from "./bookActionType";

export function createBook(book: Book): BookActionType {
    return {type: CREATE_BOOK, payload: book}
}