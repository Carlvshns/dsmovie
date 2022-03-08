import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";

function Listing(){
    return(
        <>
            <Pagination />

            <div className="container">
                <div className="rows">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-2">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-2">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-2">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-2">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-2">
                        <MovieCard />
                    </div>
                </div>
            </div>
        </>
    );
}

export default Listing;