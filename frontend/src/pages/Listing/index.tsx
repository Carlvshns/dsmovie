import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { BASE_URL } from "utils/requests";

function Listing(){
    
    // Forma errada
    axios.get(`${BASE_URL}/movies?size=12&page=0`).then(response => {
        console.log(response.data)
    });

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