import React, {ChangeEvent, Component, FormEvent, ReactNode} from "react";
import {connect} from "react-redux";
import {createBook} from "../../redux/book/bookAction";

class BookPage extends Component<BookProps, BookState> {

    state = {book: {title: '', author: ''}};

    render(): ReactNode {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <h2>Books</h2>
                    <h3>Add Books</h3>
                    <input type='text'
                           onChange={this.handleChange}
                           value={this.state.book.title}
                    />
                    <input type='submit' value='Save'/>


                    {
                        this.props
                        .books
                        .map(book => (
                        <div key={book.title}>{book.title}</div>
                        ))
                    }
                </form>
            </div>
        );
    }

    private handleChange = (event: ChangeEvent<HTMLInputElement>) => {
        const book:Book = { ...this.state.book, title: event.target.value};
        this.setState({ book });
    };

    private handleSubmit = (event: FormEvent) => {
        event.preventDefault();
        this.props.createBook(this.state.book);
    }
}

interface BookProps {
    createBook(book: Book): void;
    books: Book[];
}

export interface BookState {
    book: Book;
}

export interface Book {
    title: string,
    author: string
}

export interface BookStoreState {
    books: Book[]
}

function mapStateToProps(state: BookStoreState) {
    return {
        books: state.books
    }
}

const mapDispatchToProps = {
    createBook: createBook
};

export default connect(mapStateToProps, mapDispatchToProps)(BookPage);