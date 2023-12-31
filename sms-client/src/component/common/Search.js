import React from 'react'

const Search = ({search, setSearch}) => {
  return (
    <div className='col-sm-6 mb-4'>
        <form>
            <input className='form-control' type='search' role='searchbox' placeholder='search students...'
                value={search} onChange={(e)=> setSearch(e.target.value)} />
        </form>
      
    </div>
  )
}

export default Search
