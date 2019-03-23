import {combineReducers} from "redux";
import BookReducer from "./book/bookReducer";

const rootReducer = combineReducers({
    books: BookReducer
});

export default rootReducer;