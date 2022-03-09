import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";

function Listing(){
    return(
        <>
            <Pagination />

            <div className="container">
                <div className="rows">
                    <div className="  Mcard">
                        <MovieCard />
                    </div>
                    <div className="  Mcard">
                        <MovieCard />
                    </div>
                    <div className="  Mcard">
                        <MovieCard />
                    </div>
                    <div className="  Mcard">
                        <MovieCard />
                    </div>
                    <div className="  Mcard">
                        <MovieCard />
                    </div>
                </div>
            </div>
        </>
    );
}

export default Listing;